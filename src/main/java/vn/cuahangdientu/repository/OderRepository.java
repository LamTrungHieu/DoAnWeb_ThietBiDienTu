package vn.cuahangdientu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.cuahangdientu.entity.Order;
import vn.cuahangdientu.entity.Shop;
import vn.cuahangdientu.entity.User;

@Repository
public interface OderRepository extends JpaRepository<Order, Integer>{
	@Query("SELECT FUNCTION('DAY', o.creationTime) as day, SUM(o.total) as total " +
            "FROM Order o WHERE o.statusOrder = 'Đã nhận' " +
            "AND FUNCTION('MONTH', o.creationTime) = :month " +
            "AND FUNCTION('YEAR', o.creationTime) = :year " +
            "AND FUNCTION('DAY', o.creationTime) <= :day " +
            "AND o.shop.id_shop = :idShop " +  // Lọc theo shop
            "GROUP BY FUNCTION('DAY', o.creationTime)")
    List<Object[]> getDailyRevenue(@Param("month") int month, @Param("year") int year,
                                   @Param("day") int day, @Param("idShop") Integer idShop);

    @Query("SELECT FUNCTION('MONTH', o.creationTime) as month, SUM(o.total) as total " +
            "FROM Order o WHERE o.statusOrder = 'Đã nhận' " +
            "AND FUNCTION('YEAR', o.creationTime) = :year " +
            "AND FUNCTION('MONTH', o.creationTime) <= :month " +
            "AND o.shop.id_shop = :idShop " +  // Lọc theo shop
            "GROUP BY FUNCTION('MONTH', o.creationTime)")
    List<Object[]> getMonthlyRevenue(@Param("year") int year, @Param("month") int month,
                                     @Param("idShop") Integer idShop);

    @Query("SELECT FUNCTION('YEAR', o.creationTime) as year, SUM(o.total) as total " +
            "FROM Order o WHERE o.statusOrder = 'Đã nhận' " +
            "AND o.shop.id_shop = :idShop " +  // Lọc theo shop
            "GROUP BY FUNCTION('YEAR', o.creationTime)")
    List<Object[]> getYearlyRevenue(@Param("idShop") Integer idShop);

    @Query("SELECT o.creationTime, SUM(o.total) " +
            "FROM Order o " +
            "WHERE o.creationTime >= :startDate AND o.creationTime < :endDate " +
            "AND o.shop.id_shop = :idShop " +  // Lọc theo shop
            "GROUP BY o.creationTime " +
            "ORDER BY o.creationTime")
    List<Object[]> findRevenueByDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,
                                     @Param("idShop") Integer idShop);

    List<Order> findByUser(User user);
    List<Order> findByShop(Shop shop);
}
