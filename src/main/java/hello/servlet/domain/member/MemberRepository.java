package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
	
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	private static final MemberRepository instance = new MemberRepository();	// 싱글톤

	public static MemberRepository getInstance() {
		return instance;
	}
	private MemberRepository() {
	}


	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}
	
	public Member findById(Long id) {
		return store.get(id);
	}
	
	public List<Member> findAll() {
		return new ArrayList<>(store.values());	// store에 있는 모든 값들을 꺼내서 새로운 리스트에 담아서 넘겨 줌
												// store에 있는 값을 변경하지 않기 위함
	}
	
	public void clearStore() {
		store.clear();
	}
}
