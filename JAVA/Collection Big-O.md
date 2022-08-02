# 목록
>[1. List](List)\
>[2. Set](Set)\
>[3. Queue](Queue)\
>[4. Map](Map)


# List
|   |add()|remove()|get()|contains()|
|---|:---:|:---:|:---:|:---:|
|ArrayList|O(1)|O(n)|O(1)|O(n)|
|LinkedList|O(1)|O(1)|O(n)|O(n)|
|CopyOnWriteArrayList|O(n)|O(n)|O(1)|O(n)|

LinkedList의 remove() 메소드는 삭제할 노드에 대한 참조를 가지고 있다는 가정하에 O(1)이다.
만일 처음부터 지울 데이터를 찾는다면 탐색이 필요하므로 O(n)이 소요된다.

# Set
|   |add()|contains()|next()|
|---|:---:|:---:|:---:|
|HashSet|O(1)|O(1)|O(h/n)|
|LinkedHashSet|O(1)|O(1)|O(1)|
|EnumSet|O(1)|O(1)|O(1)|
|TreeSet|O(log n)|O(log n)|O(log n)|
|CopyOnWriteArraySet|O(n)|O(n)|O(1)|
|ConcurrentSkipList|O(log n)|O(log n)|O(1)|

HashSet에서 next() 메소드는 O(h/n)의 시간 복잡도를 갖는다. h는 해시 버킷 사이즈를 의미하고,
n은 HashSet에 저장되는 데이터의 사이즈를 의미한다. h/n 이라는 값은 엘리먼트에 비해 해시 버킷의 수가 늘어나면
해시 버킷으로 사용되는 배열의 대부분이 비어있게 되고, 엘리먼트가 담겨 있는 해시버킷을 찾기 위해 매번 비어 있는 해시 버킷을 
방문해야하기 때문에 h가 들어간다. 엘리먼트의 숫자가 늘어나면 해시 버킷이 비어 있을 가능성이 줄어들게 되고 O(1)에 근접하게 된다.
# Queue

# Map
