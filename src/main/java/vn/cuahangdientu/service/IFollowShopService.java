package vn.cuahangdientu.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import vn.cuahangdientu.entity.FollowShop;
import vn.cuahangdientu.entity.Shop;

public interface IFollowShopService {
	boolean isFollowed(Shop shop, User user);

    List<FollowShop> getShopsFollowedByUser(Integer userId);
}
