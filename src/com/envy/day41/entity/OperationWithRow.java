package com.envy.day41.entity;

import com.envy.day41.service.JaggedArrayService;

import java.util.function.Function;

public enum OperationWithRow implements Function<int[], Integer> {
    MAX {
        @Override
        public Integer apply(int[] ints) {
            return JaggedArrayService.indexOfRowElementByCondition(ints, true);
        }
    },
    MIN {
        @Override
        public Integer apply(int[] ints) {
            return JaggedArrayService.indexOfRowElementByCondition(ints, false);
        }
    },
    SUM {
        @Override
        public Integer apply(int[] ints) {
            int sum = 0;
            for (int i = 0; i < ints.length; i++) {
                sum += ints[i];
            }
            return sum;
        }
    }
}
