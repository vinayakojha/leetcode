class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Match as long of a prefix with target as possible
        int matchLen = 0;
        while (matchLen < n && count[target.charAt(matchLen) - 'a'] > 0) {
            count[target.charAt(matchLen) - 'a']--;
            matchLen++;
        }

        // If target was completely matched, back up one position so we can make it strictly greater
        if (matchLen == n) {
            matchLen--;
            count[target.charAt(matchLen) - 'a']++;
        }

        // Backtrack from matchLen down to 0
        for (int i = matchLen; i >= 0; i--) {
            char targetChar = target.charAt(i);
            int nextChar = -1;

            // Find the smallest character strictly greater than target[i]
            for (int c = targetChar - 'a' + 1; c < 26; c++) {
                if (count[c] > 0) {
                    nextChar = c;
                    break;
                }
            }

            if (nextChar != -1) {
                StringBuilder sb = new StringBuilder(n);
                
                // Add the matching prefix
                sb.append(target, 0, i);
                
                // Add the strictly greater character at position i
                sb.append((char) ('a' + nextChar));
                count[nextChar]--;

                // Append remaining characters in ascending order
                for (int c = 0; c < 26; c++) {
                    while (count[c] > 0) {
                        sb.append((char) ('a' + c));
                        count[c]--;
                    }
                }
                return sb.toString();
            }

            // Restore character at index i - 1 for the next backtrack step
            if (i > 0) {
                count[target.charAt(i - 1) - 'a']++;
            }
        }

        return "";
    }
}