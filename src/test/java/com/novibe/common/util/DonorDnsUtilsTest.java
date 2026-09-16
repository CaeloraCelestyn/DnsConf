package com.novibe.common.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DonorDnsUtilsTest {

    @Test
    void keepsCurrentIpWhenDonorStillReturnsIt() {
        assertEquals("1.1.1.2", DonorDnsUtils.chooseIp("1.1.1.2", List.of("1.1.1.1", "1.1.1.2", "1.1.1.3")));
    }

    @Test
    void takesFirstDonorIpWhenCurrentIpIsOutdated() {
        assertEquals("1.1.1.1", DonorDnsUtils.chooseIp("9.9.9.9", List.of("1.1.1.1", "1.1.1.2")));
    }

    @Test
    void keepsCurrentIpWhenDonorReturnsNothing() {
        assertEquals("9.9.9.9", DonorDnsUtils.chooseIp("9.9.9.9", List.of()));
    }
}
