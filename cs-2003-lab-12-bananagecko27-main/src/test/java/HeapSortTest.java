package test.java;

/**
 * DO NOT DISTRIBUTE.
 *
 * This code is intended to support the education of students associated
 * with the Tandy School of Computer Science at the University of Tulsa.
 * It is not intended for distribution and should remain within private
 * repositories that belong to Tandy faculty, students, and/or alumni.
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import main.java.HeapSort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.java.TUGrader.DisplayName;
import test.java.TUGrader.TestGroup;

/**
 * This class provides a set of unit tests for {@link HeapSort}
 * using the JUnit testing framework and the Java Reflection API.
 */
public class HeapSortTest {

  @Before
  public void setup() {
    TUGrader.silenceStdout();
  }

  @After
  public void cleanup() {
    TUGrader.resetStdIO();
  }

  @Test
  @TestGroup("heapify")
  @DisplayName("heapify should heapify the slice in-place")
  public void testHeapifyIntegers() {
    List<Integer> list =
        new ArrayList<>(List.of(31, 30, 74, 81, 56, 74, 22, 95, 52, 36, 82, 74, 31));
    Integer[] arr = list.toArray(Integer[]::new);
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
      HeapSort.heapify(arr, i, arr.length);
    }
    assertThat(arr, is(arrayContaining(95, 82, 74, 81, 56, 74, 22, 30, 52, 36, 31, 74, 31)));
  }

  @Test
  @TestGroup("sort")
  @DisplayName("sort should sort the array in-place")
  public void testSortIntegers() {
    List<Integer> list =
        new ArrayList<>(List.of(31, 30, 74, 82, 56, 74, 22, 95, 52, 36, 82, 74, 31));
    Integer[] arr = list.toArray(Integer[]::new);
    HeapSort.sort(arr);
    Collections.sort(list);
    assertThat(arr, is(arrayContaining(list.toArray(Integer[]::new))));
  }
}
