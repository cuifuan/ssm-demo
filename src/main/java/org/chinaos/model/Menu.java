package org.chinaos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Data
@NoArgsConstructor
public class Menu {
    private Long id;
    private String url;
    private String path;
    private Object component;
    private String name;
    private String iconCls;
    private Long parentId;
    private List<Role> roles;
    private List<Menu> children;
    private boolean keepAlive;
    private boolean requireAuth;

}
