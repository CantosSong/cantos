package top.cantos.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "member")
public class MemberEntity {
//    姓名、性别、生日、联系方式、证件号、卡号、卡密码、发展来源、注册时间、积分、余额，添加之后自动生成会员编号
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String memberNo;
	private String name;
	private Integer gender;// 0-男，1-女
	private String birth;
	private String phone;
	private String identity;
	private String cardNo;
	private String cardPassword;
	private String source;
	private Integer coins;
	private Integer balance;

}
