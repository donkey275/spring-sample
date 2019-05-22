package com.donkey.training.java8.test;

import com.donkey.training.java8.bean.Dish;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Stream extends TestCase {
    List<Dish> menu;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        menu = new ArrayList<>();
        menu.add(new Dish("pork", 500));
        menu.add(new Dish("beef", 600));
        menu.add(new Dish("chicken", 700));
        menu.add(new Dish("fish", 400));
        menu.add(new Dish("lamb", 800));
        menu.add(new Dish("rice", 300));

    }

    public void testStreamBasic() {
        List<String> names = menu.stream()
                .filter(d -> {
                    log.info("filter: " + d.getName());
                    return d.getCalories() > 300; })
                .map(d -> {
                    log.info("map: " + d.getName());
                    return d.getName();
                })
                .collect(Collectors.toList());
        log.info(names.toString());

    }

    public void testStreamWithoutSorted() {
        List<String> names = menu.stream()
                .filter(d -> {
                    log.info("filter: " + d.getName());
                    return d.getCalories() > 300; })
                .map(d -> {
                    log.info("map: " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        log.info(names.toString());

    }

    public void testStreamWithSorted() {
        List<String> names = menu.stream()
                .filter(d -> {
                    log.info("filter: " + d.getName());
                    return d.getCalories() > 300; })
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(d -> {
                    log.info("map: " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        log.info(names.toString());

    }

}