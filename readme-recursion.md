L40- combination sum 2
1. when k == 0, make sure to add result.add(new ArrayList < > (ds)); and not result.add(ds) 
2. ds.remove(ds.size() - 1); and not ds.remove(candidates[i][]);