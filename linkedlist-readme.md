### Always check for base cases in LL problems

L141
while (fastPointer.next != null && fastPointer.next.next != null) and not 
while (slowPointer.next != null && fastPointer.next.next != null)
