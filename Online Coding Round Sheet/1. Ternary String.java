static class Task {
    public void solve(int testNumber, FastReader scan, PrintWriter out) {
        String s = scan.next();
        List<Pair> al = new ArrayList<>();
        for (char c : s.toCharArray()) {
            int value = c - '0';
            if (al.size() == 0 || al.get(al.size() - 1).value != value)
                al.add(new Pair(value, 1));
            else
                al.get(al.size() - 1).freq++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < al.size() - 1; i++) {
            Pair p = al.get(i);
            if (al.get(i - 1).value != al.get(i + 1).value)
                ans = Math.min(ans, p.freq + 2);
        }
        if (ans > s.length())
            ans = 0;
        out.println(ans);
    }

    private class Pair {
        int value;
        int freq;

        Pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
}