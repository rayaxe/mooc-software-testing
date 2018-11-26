package tudelft.sum;

import java.util.ArrayList;
import java.util.Collections;

// Source: https://leetcode.com/problems/add-two-numbers/description/
class TwoNumbersSum {

    /**
     * Maurício Aniche: "My most common mistake is to always forget to do "the last iteration of a loop".
     * In some algorithms, we still need to do some processing after the "for" loop ends. I always forget it."
     *
     * @see <a href="https://courses.edx.org/courses/course-v1:DelftX+ST1x+3T2018/course/">Automated Software Testing: Practical Skills for Java Developers</a>
     */
    public ArrayList<Integer> addTwoNumbers(ArrayList<Integer> first, ArrayList<Integer> second) {
        Collections.reverse(first);
        Collections.reverse(second);

        int complement = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.max(first.size(), second.size()); i++) {
            int firstVal = i < first.size() ? first.get(i) : 0;
            int secondVal = i < second.size() ? second.get(i) : 0;
            int total = firstVal + secondVal + complement;
            complement = 0;
            if (total >= 10) {
                complement = 1;
                total -= 10;
            }
            result.add(i, total);
        }

        // Fix: additional processing after the "for" loop ends
        if (complement > 0) {
            result.add(complement);
        }

        Collections.reverse(result);
        return result;
    }
}
