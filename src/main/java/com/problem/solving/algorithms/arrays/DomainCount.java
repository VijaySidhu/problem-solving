package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainCount {

    public static void main(String[] args) {
        String[] dc = new String[]{"9001 discuss.leetcode.com"};
        domainCount(dc).stream().forEach(s -> {
            System.out.println(s);
        });

    }


    public static List<String> domainCount(String[] domainCount) {
        List<String> domainCounts = new ArrayList<>();
        if (domainCount == null || domainCount.length == 0) {
            return domainCounts;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String dc : domainCount) {
            int pos = dc.indexOf(" ");
            int num = Integer.valueOf(dc.substring(0, pos));
            String domains = dc.substring(pos + 1);
            while (!domains.isEmpty()) {
                map.put(domains, map.getOrDefault(domains, 0) + num);
                pos = domains.indexOf(".");
                domains = pos > -1 ? domains.substring(pos + 1) : "";
            }
        }
        for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            String domain = entrySet.getKey();
            Integer count = entrySet.getValue();
            domainCounts.add(count + " " + domain);
        }

        return domainCounts;
    }
}
