package cn.tekin.api.controller;

import cn.tekin.api.entity.User;
import cn.tekin.api.repository.UserRepo;
import cn.tekin.api.utils.result.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    /**
     * logback日志
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping(value = "list")
//    private List<User> getAllUser(){
//        List<User> users = userService.getAllUser();
//        logger.warn("用户获取成功");
//        return users;
//    }
//
        //用户仓库
        @Autowired
        UserRepo userRepo;

    /**
     * 根据用户ID获取带用户地址的用户数据
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/address")
    public ApiResponse getUserWithAddress(@PathVariable Long id){
        User usersWithAddress = userRepo.findUserWithAddress(id);

        if (usersWithAddress != null) {
            logger.info("用户获取成功"+usersWithAddress);
            return ApiResponse.success(usersWithAddress);
        }else{
            logger.warn("ID为 "+id+" 的数据没有找到");
            return ApiResponse.fail("400","ID为 "+id+" 的数据没有找到");
        }
    }


    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/cars")
    public ApiResponse getUserCars(@PathVariable Long id){
        User userCars = userRepo.findUserWithCars(id);

        logger.info(userCars.toString());

        if (userCars == null) {
            return ApiResponse.fail("400","暂无数据");
        }else{
            return ApiResponse.success(userCars);
        }
    }

    /**
     * 返回所有用户信息
     * @return
     */
    @RequestMapping(value = "/lists")
    public ApiResponse userLists(){
        List<User> userLists = userRepo.findAll();
        return ApiResponse.success(userLists);
    }





}
