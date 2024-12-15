package vn.cuahangdientu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import vn.cuahangdientu.entity.FollowShop;
import vn.cuahangdientu.entity.Shop;
import vn.cuahangdientu.repository.FollowShopRepository;
import vn.cuahangdientu.repository.UserRepository;
import vn.cuahangdientu.service.IFollowShopService;

@Service
public class FollowShopService implements IFollowShopService {
	@Autowired
    private FollowShopRepository followShopRepository;
    @Autowired
    private UserRepository userRepository;

    // Thêm một bản ghi FollowShop
    public void addFollowShop(User user, Shop shop) {
        FollowShop followShop = new FollowShop();
        followShop.setUser(user); // Gán user
        followShop.setShop(shop); // Gán shop

        // Lưu bản ghi FollowShop vào cơ sở dữ liệu
        followShopRepository.save(followShop);
    }


    // Xóa theo user và shop (nếu bạn muốn xóa theo user và shop cụ thể)
    public void deleteFollowShopByUserAndShop(User user, Shop shop) {
        followShopRepository.findAll().stream()
                .filter(f -> f.getUser().equals(user) && f.getShop().equals(shop))
                .findFirst().ifPresent(followShop -> followShopRepository.delete(followShop));

    }

    @Override
    public boolean isFollowed(Shop shop, User user) {
        return followShopRepository.existsByShopAndUser(shop, user);
    }

    @Override
    public List<FollowShop> getShopsFollowedByUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        return followShopRepository.findByUser(user);
    }
}
