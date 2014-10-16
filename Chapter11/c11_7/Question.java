import java.util.ArrayList;
import java.util.Collections;

public class Question {
    ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items) {
	Collections.sort(items);
	return longestIncreasingSubsequence(items);
    }

    void longestIncreasingSubsequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int current_index) {
	if (current_index >= array.size() || current_index < 0) {
	    return;
	}
	HtWt current_element = array.get(current_index);

	ArrayList<HtWt> best_sequence = null;
	for (int i = 0; i < current_index; i++) {
	    if (array.get(i).isBefore(current_element)) {
		best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
	    }
	}
	ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
	if (best_sequence != null) {
	    new_solution.addAll(best_sequence);
	}
	new_solution.add(current_element);

	solutions[current_index] = new_solution;
	longestIncreasingSubsequence(array, solutions, current_index + 1);
    }

    ArrayList<HtWt> longestIncreasingSubsequence(ArrayList<HtWt> array) {
	ArrayList<HtWt>[] solutions = new ArrayList[array.size()];
	longestIncreasingSubsequence(array, solutions, 0);

	ArrayList<HtWt> best_sequence = null;
	for (int i = 0; i < array.size(); i++) {
	    best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
	}
	return best_sequence;
    }

    ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
	if (seq1 == null) {
	    return seq2;
	}
	if (seq2 == null) {
	    return seq1;
	}
	return seq1.size() > seq2.size() ? seq1 : seq2;
    }

}
