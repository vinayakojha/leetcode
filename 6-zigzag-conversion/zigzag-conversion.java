class Solution {
    public String convert(String s, int numRows) {
        // Base case: no zigzag possible if only 1 row or string fits in one vertical column
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Initialize StringBuilder for each row to optimize string concatenation
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction when hitting the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down to the next row index
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all row contents sequentially into a final single layout
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}