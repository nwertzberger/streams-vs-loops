package com.ideaheap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsBasedCalculator {

    public Map<String, String> getStringTransition(
        final Set<String> stringSet,
        final Map<String, Double> stringCosts) {

        return stringCosts.keySet().parallelStream().collect(
            Collectors.toConcurrentMap(
                (state) -> state,
                (state) -> stringTransitionCost(state, stringSet, stringCosts)
            )
        );
    }

    private String stringTransitionCost(
        final String state,
        final Set<String> stringSet,
        final Map<String, Double> expectedUtilities) {

        return Double.toString(stringSet
        .stream()
        .mapToDouble(act -> calculateExpectedUtility(state, act, expectedUtilities))
        .max()
        .getAsDouble());
    }
//
    private Double calculateExpectedUtility(
        String state,
        String act,
        Map<String, Double> expectedUtilities) {

        return expectedUtilities
            .entrySet()
            .stream()
            .mapToDouble(
                n -> getStateProbability(state, act, n.getKey()) * n.getValue()
            ).sum();
    }

    private Double getStateProbability(String state, String act, String key) {
        return 5.0;
    }

}
