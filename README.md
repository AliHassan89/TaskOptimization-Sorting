# TaskOptimization-Sorting

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

# Solution
1. Array list which is recevied as function parameter is sorted.

2. A new array is created of the same length in which the difference between two tasks + the value of prev task is stored.
e.g we recevied following a list as argument
24, 23, 22, 10, 20
we sorted it:
10, 20, 22, 23, 24
then we store difference between two tasks + value of prev task
10  20  22  23  24
|___|___|___|___|
 10   2   1   1

diff[] = {20, 22, 23, 24, 24}

3. Sort the array diff

4. Loop through the diff array and keep subtracting diff array value from T.
