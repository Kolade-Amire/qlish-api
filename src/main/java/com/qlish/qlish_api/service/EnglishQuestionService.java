package com.qlish.qlish_api.service;

import com.qlish.qlish_api.entity.EnglishQuestionEntity;
import com.qlish.qlish_api.constants.english_enums.EnglishQuestionClass;
import com.qlish.qlish_api.constants.english_enums.EnglishQuestionLevel;
import com.qlish.qlish_api.constants.english_enums.EnglishQuestionTopic;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.List;

public interface EnglishQuestionService {

    List<EnglishQuestionEntity> getEnglishQuestions(Pageable pageable, @Nullable EnglishQuestionLevel questionLevel, @Nullable EnglishQuestionClass questionClass, @Nullable EnglishQuestionTopic questionTopic, int testSize);
}