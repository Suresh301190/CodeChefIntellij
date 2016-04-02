import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

    private static final PrintStream out = new PrintStream(System.out), err = new PrintStream(System.err);
    private static final long mod109 = 1000000009L, mod107 = 1000000007L;
    private static final int offset = (1 << ((int) Math.ceil((Math.log(mod109) / Math.log(2))))) - 1;
    private static final BigInteger ten = BigInteger.valueOf(10L), two = BigInteger.valueOf(2L);
    private static final double e = 1e-14;
    private static Parser p;
    /**
     * Used to decide if we are running in local or not
     */
    private static boolean DEBUG = false;
    private StringBuilder sb = new StringBuilder(), osb = new StringBuilder();
    private int A, B, N, M, P, Q, R, K, X, Y, L, ans, min, max, num, sum;
    private long Al, Bl, Nl, Ml, Pl, Ql, Rl, Kl, Xl, Yl, ansl, minl, maxl, numl, suml;
    private int[] nums;
    private long[] numsl, fact;
    private boolean[] visit;
    private TreeMap<Integer, Integer> tmap = new TreeMap<>();
    private HashMap<Integer, Integer> hmap = new HashMap<>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private ArrayList<BigInteger> prime;

    /**
     * Main function which initializes the {@link Parser} and then calls the {@link Main#solve()}
     *
     * @param args cmd line args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        InputStream is;
        if (args.length > 0 && args[0].equals("Test")) {
            is = new BufferedInputStream(new FileInputStream(new File("res/" + args[1])));
            DEBUG = true;
        } else {
            is = System.in;
        }
        p = new Parser(is);
        new Main().solve();
    }

    /**
     * Solve which actually has the problem solving code.
     */
    private void solve() {
        for (int run = 1, testCount = p.nextInt(); run <= testCount; run++) {
            Nl = p.nextLong();
            Ml = p.nextLong();

            if (DEBUG) {
                sb.append("Iter : ").append(run).append("\n");
            }

            if (Nl == 2 || Ml == 2) {
                sb.append("Yes\n");
            } else if (Nl == 1 || Ml == 1 || ((Nl % 2) != 0 && (Ml % 2) != 0)) {
                sb.append("No\n");
            } else {
                sb.append("Yes\n");
            }
        }

        // print the output
        out.print(sb.toString());
    }

    /**
     * Parser class to parse the input fron STDIN or a File
     */
    private static class Parser {
        private static final int BufferSize = 65536, ZERO = 0;
        private BufferedInputStream bis;
        private byte read;
        private int BufferPointer, BufferEnd;
        private byte[] buffer = new byte[BufferSize];

        /**
         * Initialize the buffer to read from
         *
         * @param in stream can be any valid stream
         */
        Parser(InputStream in) throws Exception {
            if (in == null)
                throw new IllegalArgumentException("Stream can't be empty");
            bis = new BufferedInputStream(in);
            BufferPointer = 0;
            BufferEnd = bis.read(buffer, ZERO, BufferSize);
        }

        /**
         * Parse the next input as an int, skips the buffer for any unpritable characters
         *
         * @return the parsed int value
         */
        int nextInt() {
            int num = 0;
            read = readNext();
            while (read <= ' ') read = readNext();
            boolean neg = read == '-';
            if (neg) read = readNext();
            do {
                num = num * 10 + (read - '0');
                read = readNext();
            } while (read > ' ');
            if (neg) return -num;
            return num;
        }

        /**
         * parse the next input as a long, skips the buffer for any unpritable characters
         *
         * @return the parsed long  value
         */
        long nextLong() {
            long num = 0L;
            read = readNext();
            while (read <= ' ') read = readNext();
            boolean neg = read == '-';
            if (neg) read = readNext();
            do {
                num = num * 10 + (read - '0');
                read = readNext();
            } while (read > ' ');
            if (neg) return -num;
            return num;
        }

        /**
         * Read the next char, skips the buffer for any unpritable characters
         *
         * @return the next char
         */
        char nextChar() {
            read = readNext();
            while (read <= ' ') read = readNext();
            return (char) read;
        }

        /**
         * Reads the next char
         *
         * @return the next char
         */
        char nextAnyChar() {
            read = readNext();
            return (char) read;
        }

        /**
         * Read the continious stream and break @first unpritable characters including space
         *
         * @return the parsed {@link String}
         */
        String nextString() {
            StringBuilder sb = new StringBuilder("");
            read = readNext();
            while (read <= ' ') read = readNext();
            do {
                sb.append((char) read);
                read = readNext();
            } while (read > ' ');
            return sb.toString();
        }

        /**
         * Reads the complete line from the current index till '\n' is processed.
         *
         * @return the parsed line
         */
        String readLine() {
            StringBuilder sb = new StringBuilder("");
            read = readNext();
            while (read <= ' ') read = readNext();
            do {
                sb.append((char) read);
                read = readNext();
            } while (read != '\n');
            return sb.toString();
        }

        /**
         * Skip the next input
         */
        void nextSkip() {
            read = readNext();
            while (read <= ' ') read = readNext();
            read = readNext();
            while (read > ' ') read = readNext();

        }

        private byte readNext() {
            if (BufferPointer == BufferEnd) fillBuffer();
            return buffer[BufferPointer++];
        }

        private void fillBuffer() {
            BufferPointer = ZERO;
            try {
                BufferEnd = bis.read(buffer, ZERO, BufferSize);
                if (BufferEnd == -1) buffer[0] = -1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
