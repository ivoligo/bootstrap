package web.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@NamedQueries( {
        @NamedQuery(name = Role.ROLE_FIND_ALL,
                query = "select r from Role r"),
        @NamedQuery(name = Role.FIND_BY_NAME,
                query = "select distinct r from Role r where r.rolesName = :rolesName"),
        @NamedQuery(name = Role.FIND_BY_NAME_LIST,
                query = "select distinct r from Role r where r.rolesName = :rolesName")
})
public class Role implements GrantedAuthority {
    public static final String ROLE_FIND_ALL = "Role.findAllRole";
    public static final String FIND_BY_NAME = "Role.findRoleByName";
    public static final String FIND_BY_NAME_LIST = "Role.findRoleByNameList";
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rolesName")
    private String rolesName;

    public Role(){
    }
    public Role(String rolesName){
        this.rolesName = rolesName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    @Override
    public String getAuthority() {
        return getRolesName();
    }
//
}
