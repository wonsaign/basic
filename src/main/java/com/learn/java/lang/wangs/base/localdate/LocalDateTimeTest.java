package com.learn.java.lang.wangs.base.localdate;

import com.google.common.collect.Lists;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class LocalDateTimeTest {

    public static final LocalDateTime TERMINAL_DATE = LocalDateTime.now().minusMonths(3).with(TemporalAdjusters.lastDayOfMonth());

        public static void main(String[] args) throws InterruptedException {

        LocalDateTimeTest t = new LocalDateTimeTest();

        t.t(
                LocalDateTime.of(2021, 4, 29, 0, 0),
                LocalDateTime.now());

//        for (int i = 0; i < 10; i++) {
//            System.out.println(TERMINAL_DATE);
//            Thread.sleep(2000L);
//        }

    }

    private void t(LocalDateTime beginDate, LocalDateTime terminalDate){
        final int gap = 1;

        if(beginDate == null){
            beginDate = LocalDateTime.of(2021, 1, 1, 0, 0);
        }
        if(terminalDate == null){
            terminalDate = LocalDateTime.now().minusMonths(3).with(TemporalAdjusters.lastDayOfMonth());
        }

        Duration duration = Duration.between(beginDate, terminalDate);

        // orgid -> counter 对应关系

//        while (duration.toDays() >= 0 && duration.toMinutes() > 0) {
//            List<Integer> days = getDatesByDays(beginDate, beginDate.plusDays(gap));
//            days.forEach(System.out::println);
//            beginDate = beginDate.plusDays(gap);
//            duration = Duration.between(beginDate, terminalDate);
//        }

        while (duration.toDays() > 0) {
            List<Integer> days = getDatesByDays(beginDate, beginDate.plusDays(gap));
            days.forEach(System.out::println);
            beginDate = beginDate.plusDays(gap);
            duration = Duration.between(beginDate, terminalDate);
        }
    }

    private List<Integer> getDatesByDays(LocalDateTime beginDate, LocalDateTime endDate) {
        Duration duration = Duration.between(beginDate, endDate);

        long diffDays = duration.toDays();
        List<Integer> days = Lists.newArrayList();
        while (diffDays-- > 0) {
            days.add(farmatDate(beginDate.plusDays(diffDays)));
        }
        return days;
    }

    private int farmatDate(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return Integer.parseInt(dateTime.format(formatter));
    }
}
