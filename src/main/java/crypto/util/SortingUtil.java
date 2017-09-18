package crypto.util;

import java.util.ArrayList;

/**
 * Created by tanerali on 16/09/2017.
 */
public class SortingUtil {

    //Taner
    //Insertion sort using generics; can be used to sort anything that
    //can be ordered (hence the use of Comparable<>)
    public static <T extends Comparable<T>> void sort(ArrayList<T> arr)
    {
        //get array length
        int n = arr.size();

        //start loop at index[1] (second element) because first element is
        //first element in new sorted list
        for (int i=1; i<n; ++i)
        {
            //item to insert into sorted list (key)
            T insertItem = arr.get(i);

            //represents the end of the ordered list
            int j = i-1;

            /* Move elements of arr[0..i-1] (i.e. sorted list), that are
               greater than insertItem (or key), to one position ahead
               of their current position */

            //while position on left is greater than position on right
            //enter while loop
            while (j > -1 && arr.get(j).compareTo(insertItem) > 0)
            {
                //move elements of array down one spot
                arr.set(j+1, arr.get(j) );
                //decrement j index
                j--;
            }
            //insert insertItem into appropriate location in list
            arr.set(j+1, insertItem);
        }
    }
}
