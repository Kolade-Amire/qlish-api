package com.qlish.qlish_api.factory;

import com.qlish.qlish_api.entity.QuestionModifier;

import java.util.Map;

public interface ModifierFactory<T extends QuestionModifier> {
        T createModifier(Map<String, String> requestParams
        );
}
