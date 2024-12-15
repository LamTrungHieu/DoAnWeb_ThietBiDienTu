package vn.cuahangdientu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import vn.cuahangdientu.entity.FollowShop;
import vn.cuahangdientu.entity.Shop;


public interface FollowShopRepository extends JpaRepository<FollowShop, Long>{
	boolean existsByShopAndUser(Shop shop, User user);
    List<FollowShop> findByUser(User user);
}
