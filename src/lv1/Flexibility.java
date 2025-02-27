package lv1;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            if (isPerfectAttendance(schedules[i], timelogs[i], startday)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPerfectAttendance(int schedule, int[] timelog, int startday) {
        int maxPermissionRange = getMaxPermissionRange(schedule);
        for (int i = 0; i < timelog.length; i++) {
            if (maxPermissionRange < timelog[i] && !isWeekend(startday + i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isWeekend(int now) {
        return now % 7 == 6 || now % 7 == 0;
    }

    public int getMaxPermissionRange(int schedule) {
        if (schedule / 100 >= 50) {
            return schedule + 50;
        }
        return schedule + 10;
    }
}
