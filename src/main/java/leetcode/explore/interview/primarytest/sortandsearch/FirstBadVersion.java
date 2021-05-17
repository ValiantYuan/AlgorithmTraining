package leetcode.explore.interview.primarytest.sortandsearch;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = new FirstBadVersion().firstBadVersion(2126753390);
        System.out.println(n);
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        if (isBadVersion(start)) {
            return 1;
        } else if (!isBadVersion(end)) {
            return -1;
        }
        while (end - start > 1) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                if (isBadVersion(mid - 1)) {
                    end = mid - 1;
                } else return mid;

            } else {
                if (isBadVersion(mid + 1)) {
                    return mid + 1;
                } else start = mid + 1;
            }
        }
        if (isBadVersion(start)) {
            return start;
        } else {
            return end;
        }

    }


    public boolean isBadVersion(int n) {
        return n >= 1702766719;
    }
}
