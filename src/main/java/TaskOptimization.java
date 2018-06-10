/**

 A worker has a set of N tasks to complete. For each task the worker knows the time in minutes it
 will take to complete. This is dependent on the difficulty of the task. So, a task with difficulty
 D takes D minutes to complete. The worker has a limited amount of time T during which he wants to
 complete as many tasks as possible.

 As mentioned above the tasks have different difficulty and when switching from one task to another
 with difficulties D1 and D2, the worker needs |D1 - D2| minutes to prepare for working on the next task.

 The number of tasks N is in the range [1, 10,000]. The total time T is in the range
 [0, 200,000,000]. The task difficulties are integer numbers in the range [1, 10,000].

 You need to write a function, which computes the maximum number of tasks that can be completed
 within the given time T. The function accepts as arguments the number N and T and a list of the
 task difficulties. It must return one integer - the maximum number of tasks that can be completed
 within the given time limit.

 Here is an example test case.

 SAMPLE INPUT
 5 65
 24 23 22 10 20

 SAMPLE OUTPUT
 3
 All five tasks cannot be completed within the allowed 65 minutes, but it is possible to accomplish
 three tasks, for example tasks 4, 5, 3 if completed in this order.

 */
package main.java;


import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class TaskOptimization {

    public int maximum_completed_tasks(int n, int t, List<Integer> task_difficulties) {
      if (n == 0)
        return 0;

      int len = task_difficulties.size();
      Collections.sort(task_difficulties);
      int[] diff = new int[len];
      for (int i=0; i<len-1; i++){
        int temp_diff = Math.abs(task_difficulties.get(i+1) - task_difficulties.get(i));
        diff[i] = task_difficulties.get(i) + temp_diff;
      }
      diff[len-1] = task_difficulties.get(len-1);
      Arrays.sort(diff);
      int tasks = 0;

      for (int i=0; i<len; i++){
        t -= diff[i];
        if (t >= 0)
          ++tasks;
        else
          break;
      }

      return tasks;
    }
}
