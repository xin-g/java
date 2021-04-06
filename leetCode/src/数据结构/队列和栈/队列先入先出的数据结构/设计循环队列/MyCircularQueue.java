package 数据结构.队列和栈.队列先入先出的数据结构.设计循环队列;

public class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.capacity = k;
        this.headIndex = 0;
        this.count = 0;
    }

    // 向循环队列插入一个元素。如果成功插入则返回真
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count++;
        return true;
    }

    // 从循环队列中删除一个元素。如果成功删除则返回真
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count--;
        return true;
    }

    // 从队首获取元素。如果队列为空，返回-1
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return this.queue[this.headIndex];
    }

    // 获取队尾元素。如果队列为空，返回-1
    public int Rear() {
        if(isEmpty())
            return -1;
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }

    // 检查循环队列是否为空
    public boolean isEmpty() {
        return (this.count == 0);
    }

    // 检查循环队列是否已满
    public boolean isFull() {
        return (this.count == this.capacity);
    }
}
