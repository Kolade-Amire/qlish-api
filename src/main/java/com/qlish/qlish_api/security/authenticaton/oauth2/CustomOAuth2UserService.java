package com.qlish.qlish_api.security.authenticaton.oauth2;


import com.qlish.qlish_api.user.AuthProvider;
import com.qlish.qlish_api.user.UserEntity;
import com.qlish.qlish_api.user.UserPrincipal;
import com.qlish.qlish_api.user.UserService;
import com.qlish.qlish_api.user.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserService userService;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = super.loadUser(userRequest);
        System.out.println("OAuth2 User Attributes: " + oauth2User.getAttributes());

        try {
            return processOAuth2User(userRequest, oauth2User);
        } catch (Exception exception) {
            System.err.println("Exception occurred: " + exception.getMessage());
            throw new OAuth2AuthenticationException("Error processing OAuth2 user: " + exception.getMessage());
        }
    }

    public OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oauth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(
                userRequest.getClientRegistration()
                        .getRegistrationId(), oauth2User.getAttributes()
        );

        UserEntity user;
        try {
            user = userService.getUserByEmail(oAuth2UserInfo.getEmail());
            user = updateExistingUser(user, oAuth2UserInfo);
        } catch (UsernameNotFoundException ex) {
            user = registerUser(userRequest, oAuth2UserInfo);
        }
        return UserPrincipal.create(user, oauth2User.getAttributes());
    }


    public UserEntity registerUser(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo) throws OAuth2AuthenticationException {
        var user = UserEntity.builder()
                .name(oAuth2UserInfo.getName())
                .email(oAuth2UserInfo.getEmail())
                .authProvider(AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase()))
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .isEmailVerified(true)
                .build();

        return userService.saveUser(user);
    }

    private UserEntity updateExistingUser(UserEntity existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.setName(oAuth2UserInfo.getName());
        return  userService.saveUser(existingUser);
    }
}
