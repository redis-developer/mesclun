package com.redislabs.lettucemod.search.aggregate.reducers;

import com.redislabs.lettucemod.search.protocol.CommandKeyword;
import com.redislabs.lettucemod.search.protocol.RediSearchCommandArgs;

public class Sum extends AbstractPropertyReducer {

    public Sum(String as, String property) {
        super(as, property);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected void buildFunction(RediSearchCommandArgs args) {
        args.add(CommandKeyword.SUM);
        args.add(1);
        args.addProperty(property);
    }

    public static SumBuilder property(String property) {
        return new SumBuilder(property);
    }

    public static class SumBuilder extends PropertyReducerBuilder<SumBuilder> {

        public SumBuilder(String property) {
            super(property);
        }

        public Sum build() {
            return new Sum(as, property);
        }
    }
}