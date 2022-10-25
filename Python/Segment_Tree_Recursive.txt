from math import log2, ceil
from sys import stdin
from bisect import bisect_left as bl
from collections import defaultdict

input = stdin.readline
read = lambda: map(int, input().strip().split())


def left(idx):
    return 2 * idx


def right(idx):
    return 2 * idx + 1


class SegmentTree:
    def __init__(self, arr):
        self.size = len(arr)
        self.tree_size = 2 ** self.size.bit_length()
        self.tree = [0] * 2 * self.tree_size
        self.idx, self.left_node, self.right_node = [1, 0, self.size - 1]
        self.build(arr)

    # Build Segment tree
    # idx: node index (initially idx= 1 (root node))
    # left_node, right_node: index of array (initialise with start and end index of array by default)
    # build(array)
    def build(self, arr, idx=1, left_node=0, right_node=None):
        if right_node is None:
            right_node = self.right_node

        if left_node + 1 == right_node:
            self.tree[left(idx)] = arr[left_node]
            self.tree[right(idx)] = arr[right_node]
            self.tree[idx] = self.tree[left(idx)] + self.tree[right(idx)]

        elif left_node == right_node:
            self.tree[idx] = arr[left_node]

        else:
            mid = (left_node + right_node) // 2
            self.build(arr, left(idx), left_node, mid)
            self.build(arr, right(idx), mid + 1, right_node)
            self.tree[idx] = self.tree[left(idx)] + self.tree[right(idx)]

    # Update element of array present at index pos with value=new_val and update Segment Tree with the new sum
    # update(index,new_value)
    def update(self, pos, new_val, idx=1, left_node=0, right_node=None):
        if right_node is None:
            right_node = self.right_node

        if left_node == right_node:
            self.tree[idx] = new_val
        else:
            mid = (left_node + right_node) // 2
            if pos <= mid:
                self.update(pos, new_val, left(idx), left_node, mid)
            else:
                self.update(pos, new_val, right(idx), mid + 1, right_node)
            self.tree[idx] = self.tree[left(idx)] + self.tree[right(idx)]

    # Return Sum of element present in [range_left,range_right] of array both inclusive
    def range_sum(self, range_left, range_right, idx=1, left_node=0, right_node=None):
        if right_node is None:
            right_node = self.right_node

        if range_left > range_right:
            return 0
        # Fully Overlap
        if left_node == range_left and right_node == range_right:
            return self.tree[idx]
        # Partial Overlap
        mid = (left_node + right_node) // 2
        return self.range_sum(range_left, min(range_right, mid), left(idx), left_node, mid) + \
               self.range_sum(max(range_left, mid + 1), range_right, right(idx), mid + 1, right_node)

# n, m = read()
# lst = list(read())
# st = SegmentTree(lst)
# for x in range(m):
#     q = list(read())
#     if q[0] == 1:
#         st.update(q[1], q[2])
#     else:
#         print(st.range_sum(q[1], q[2] - 1))