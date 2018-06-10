package test.java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import main.java.TaskOptimization;
import org.junit.Test;

public class TaskOptimizationTest {

  private static final TaskOptimization taskOptimization = new TaskOptimization();

  @Test
  public void shouldReturn3(){
    //given
    List<Integer> list = new ArrayList<>();
    list.add(24);
    list.add(23);
    list.add(22);
    list.add(10);
    list.add(20);

    int expected = 3;

    //when
    int result = taskOptimization.maximum_completed_tasks(5, 65, list);

    //then
    assertThat(result, equalTo(expected));
  }

}
