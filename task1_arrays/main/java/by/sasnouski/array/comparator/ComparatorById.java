package by.sasnouski.array.comparator;

import java.util.Comparator;

    public class ComparatorById implements Comparator<Integer> {
  /*      @Override
        public int compare(CustomArrayImpl o1, CustomArrayImpl o2) {
            return Long.compare(o1.getId(), o2.getId());
        }

        @Override
        public int compare(Double o1, Double o2) {
            return Double.;
        }
    }*/

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
}
