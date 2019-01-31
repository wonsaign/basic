package com.learn.java.lang.wangs.util.guava;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map.Entry;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.BiMap;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeSet;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;

import org.checkerframework.checker.nullness.qual.Nullable;

public class GuavaTest {

    public static void main(String[] args) {
        collections2();
    }

    private static void collections2() {
        Maps.asMap(Sets.newHashSet(), (Function<Integer, String>) (@Nullable Integer input) -> "hi");
    }

    @SuppressWarnings("unused")
    private static void test() {
        Optional<?> o = Optional.of(5);
		java.util.Optional<?> oo = java.util.Optional.of(5);
        
        Objects.equal(null, "a");
        java.util.Objects.equals(null, "a");
        ComparisonChain.start().compare(1, 2).compare(2, 3).result();
		
		ImmutableSet.of(1,2,3);
		// 都是静态工厂代替 new 
		BiMap<Integer, String> bimap = HashBiMap.create();
		bimap.put(1, "a");
		bimap.put(2, "b");
		bimap.put(3, "c");
		BiMap<String, Integer> invermap = bimap.inverse();
		for (Entry<String, Integer> i : invermap.entrySet()) {
			System.err.println(i.getKey()+"-----"+i.getValue());
		}
		// 相当于Map<key1,Map<key2,value>>
		Table<?, ?, ?> table = HashBasedTable.create();
		// 相当于数据库中的并集
        RangeSet<Integer> rs = TreeRangeSet.create();
        // Range 区间函数
		rs.add(Range.closed(1, 10));
		rs.add(Range.closedOpen(5, 10));
        rs.add(Range.openClosed(9, 15));
        
        List<?> result = Lists.newArrayList();
        PeekingIterator<?> iter = Iterators.peekingIterator(result.iterator());
        iter.peek();// 类似callable中的Future对象,可以预先获取
    }

    @SuppressWarnings("unused")
    private static void cacheTest() {
        LoadingCache<String,Integer> graphs = CacheBuilder.newBuilder().maximumSize(1000).build(
            new CacheLoader<String ,Integer>(){
                    @Override
                    public Integer load(String key) throws Exception {
                        return null;
                    }
            });
    }

    @SuppressWarnings("unused")
    private static void joinTest() {
        Joiner j = Joiner.on("").skipNulls();
        j.join("parts","of","value");
        // 类似jdk中的String.split方法,但是返回的结果更正确
        Splitter.on("a");

        CharMatcher.javaIsoControl();
        Charset utf8 = Charsets.UTF_8;
    }

    @SuppressWarnings("unused")
    private static void mathTest() {
        // 对界限都计算的很好
        IntMath.checkedAdd(1, 2);
        LongMath.checkedAdd(1L, 2L);
    }

    @SuppressWarnings("unused")
    private static void reflectTest() {
        
    }
}