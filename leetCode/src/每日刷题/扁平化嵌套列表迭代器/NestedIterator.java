package 每日刷题.扁平化嵌套列表迭代器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> vals;
    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.vals = new ArrayList<>();
        dfs(nestedList);
        this.cur = vals.iterator();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for(NestedInteger nest : nestedList){
            if(nest.isInteger()){
                vals.add(nest.getInteger());
            }else {
                dfs(nest.getList());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    @Override
    public Integer next() {
        return cur.next();
    }
}
