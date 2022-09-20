MaxPathSum

1. we need int[] max = new int[1]; since pass by reference for integers does not work
2. if you swap         int leftNodeMaxSum = Math.max(0,rec(root.left, max));
                       int rightNodeMaxSum = Math.max(0,rec(root.right, max));
                       
                       with
                       
                               int leftNodeMaxSum = rec(root.left, max);
                               int rightNodeMaxSum = rec(root.right, max);
                               
some test cases will fail, since we want to ignore negative path sums from children 