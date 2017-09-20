import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NMeetingsInARoom {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= noOfTestCases; i++) {
            String numberOfMeetingsStr = scanner.nextLine();
            int numberOfMeetings = Integer.parseInt(numberOfMeetingsStr);
            String startingTimeStr = scanner.nextLine();
            String endTimeStr = scanner.nextLine();
            String[] startTimeArr = startingTimeStr.split(" ");
            String[] endTimeArr = endTimeStr.split(" ");
            Set<Meeting> meetingSet = createMeetingSet(startTimeArr, endTimeArr, numberOfMeetings);
            Set<Meeting> scheduleMeetings = scheduleMeetings(meetingSet);
            showScheduledMeetings(scheduleMeetings);
        }
    }

    private static void showScheduledMeetings(Set<Meeting> scheduleMeetings) {
        for (Meeting meeting : scheduleMeetings) {
            System.out.print(meeting.getIndex() + " ");
        }
        System.out.print("\n");
    }

    private static Set<Meeting> scheduleMeetings(Set<Meeting> meetingSet) {
        Set<Meeting> scheduledMeetings = new TreeSet<>();
        int minOfStartTime = getMinOfStartTime(meetingSet);
        int maxOfEndTime = getMaxOfEndTime(meetingSet);
        boolean[] slots = new boolean[maxOfEndTime - minOfStartTime + 1];
        for (Meeting meeting : meetingSet) {
            boolean ifSlotAvailable = checkIfSlotAvailable(meeting.getStartTime(), meeting.getEndTime(), slots, minOfStartTime);
            if (ifSlotAvailable) {
                markSlotAlloted(meeting.getStartTime(), meeting.getEndTime(), slots, minOfStartTime);
                scheduledMeetings.add(meeting);
            }
        }
        return scheduledMeetings;
    }

    private static void markSlotAlloted(int startTime, int endTime, boolean[] slots, int baseStartTime) {
        int startIdx = startTime - baseStartTime;
        int endIx = endTime - baseStartTime;
        for (int i = startIdx; i <= endIx; i++) {
            slots[i] = true;
        }
    }

    private static boolean checkIfSlotAvailable(int startTime, int endTime, boolean[] slots, int baseStartTime) {
        int startIdx = startTime - baseStartTime;
        int endIx = endTime - baseStartTime;
        for (int i = startIdx; i <= endIx; i++) {
            if (slots[i]) {
                return false;
            }
        }
        return true;
    }


    private static int getMaxOfEndTime(Set<Meeting> meetingSet) {
        int maxOfEndTime = 0;
        for (Meeting meeting : meetingSet) {
            int endTime = meeting.getEndTime();
            if (maxOfEndTime < endTime) {
                maxOfEndTime = endTime;
            }
        }
        return maxOfEndTime;
    }

    private static int getMinOfStartTime(Set<Meeting> meetingSet) {
        int minOfStartTime = 0;
        for (Meeting meeting : meetingSet) {
            int startTime = meeting.getStartTime();
            if (minOfStartTime > startTime) {
                minOfStartTime = startTime;
            }
        }
        return minOfStartTime;
    }

    private static Set<Meeting> createMeetingSet(String[] startingTimeArr, String[] endTimeArr, int numberOfMeetings) {
        Set<Meeting> meetingSet = new TreeSet<>();
        for (int i = 0; i < numberOfMeetings; i++) {
            int startTime = Integer.parseInt(startingTimeArr[i]);
            int endTime = Integer.parseInt(endTimeArr[i]);
            Meeting meeting = new Meeting(startTime, endTime, i + 1);
            meetingSet.add(meeting);
        }
        return meetingSet;
    }

    private static class Meeting implements Comparable {
        private final int startTime;
        private final int endTime;
        private final int duration;
        private final int index;

        Meeting(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
            this.duration = endTime - startTime;
        }

        int getStartTime() {
            return startTime;
        }

        int getEndTime() {
            return endTime;
        }

        int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Object o) {
            Meeting that = (Meeting) o;
            if (this.duration >= that.duration) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
