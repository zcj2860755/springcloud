
package com.zdzc.utils.treeUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 /**
 * Description : 树节点，所有需要实现树节点的，都需要继承该类
 * Author : 李琳青
 * Date : 2019-08-14 14:48
 */

public class TreeNode<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 上级ID
     */
    private String parentId;
    /**
     * 子节点列表
     */
    private List<T> children = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}