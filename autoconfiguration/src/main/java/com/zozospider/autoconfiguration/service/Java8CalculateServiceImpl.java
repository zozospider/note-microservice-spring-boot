package com.zozospider.autoconfiguration.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Java 8 Lambda 实现 {@link CalculateService}
 *
 * @author zozo
 * @since 1.0
 */
@Profile("Java8")
@Service
public class Java8CalculateServiceImpl implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 8 Lambda 实现求和");
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }

}
