USE travelagents;

INSERT INTO tbl_user (name, tel, address, email, username, password, role)
VALUES ('Anh Quan', '0123456789', 'Viet Nam', 'anhquan@gmail.com', 'anhquan', '12345678', 'ROLE_ADMIN');

INSERT INTO tbl_user (name, tel, address, email, username, password, role)
VALUES ('Dinh Dai', '0123456788', 'Viet Nam', 'dinhdai@gmail.com', 'dinhdai', '12345678', 'ROLE_ADMIN');

INSERT INTO tbl_user (name, tel, address, email, username, password, role)
VALUES ('Viet Anh', '0123456787', 'Viet Nam', 'vietanh@gmail.com', 'vietanh', '12345678', 'ROLE_AGENT');

INSERT INTO tbl_user (name, tel, address, email, username, password, role)
VALUES ('Viet Anh', '0123456786', 'Viet Nam', 'vietanh2@gmail.com', 'vietanh2', '12345678', 'ROLE_AGENT');

INSERT INTO tbl_user (name, tel, address, email, username, password, role)
VALUES ('Dac Anh 1', '0123456785', 'Yen Nghia', 'dacanh@gmail.com', 'dacanh', '12345678', 'ROLE_CUSTOMER');

INSERT INTO tbl_user (name, tel, address, email, username, password, role)
VALUES ('Dac Anh 2', '0123456784', 'Yen Nghia', 'dacanh2@gmail.com', 'dacanh2', '12345678', 'ROLE_CUSTOMER');

INSERT INTO tbl_user (name, tel, address, email, username, password, role)
VALUES ('Dac Anh 3', '0123456783', 'Yen Nghia', 'dacanh3@gmail.com', 'dacanh3', '12345678', 'ROLE_TOUR_GUIDE');

INSERT INTO tbl_user (name, tel, address, email, username, password, role)
VALUES ('Dac Anh 4', '0123456789', 'Yen Nghia', 'dacanh4@gmail.com', 'dacanh4', '12345678', 'ROLE_TOUR_GUIDE');

INSERT INTO tbl_city (name, code)
VALUES ('Ha Noi', 1);

INSERT INTO tbl_city (name, code)
VALUES ('TP Ho Chi Minh', 2);

INSERT INTO tbl_city (name, code)
VALUES ('Hai Phong', 3);

INSERT INTO tbl_city (name, code)
VALUES ('Da Nang', 4);

INSERT INTO tbl_city (name, code)
VALUES ('Cao Bang', 6);

INSERT INTO tbl_city (name, code)
VALUES ('Tuyen Quang', 9);

INSERT INTO tbl_city (name, code)
VALUES ('Thai Nguyen', 12);

INSERT INTO tbl_city (name, code)
VALUES ('Quang Ninh', 17);

INSERT INTO tbl_city (name, code)
VALUES ('Ba Ria - Vung Tau', 52);

INSERT INTO tbl_tour_info (name, price_per_person, max_slot, duration, is_one_time, agent_id)
VALUES ('Hà Nội - Yên Tử - Nghỉ Dưỡng Du Thuyền Hạ Long', 50, 10, 4, 0, 3);

INSERT INTO tbl_tour_info (name, price_per_person, max_slot, duration, is_one_time, agent_id)
VALUES ('Hà Nội - Sapa - Bản Cát Cát - Fansipan - Ninh Bình - Tràng An - Bái Đính - Tuyệt Tịnh Cốc - Hạ Long - Đảo Titốp - Yên Tử',
    100, 15, 7, 0, 4);

INSERT INTO tbl_tour_info (name, price_per_person, max_slot, duration, is_one_time, agent_id)
VALUES ('Hà Nội - Sapa - Bản Cát Cát - Fansipan - Cổng Trời Ô Quy Hồ',
    45, 10, 4, 1, 3);

INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('SB NỘI BÀI - HÀ NỘI',
    'Quý khách tập trung tại sân bay Tân Sơn Nhất (ga nội địa), hướng dẫn viên hỗ trợ khách làm thủ tục đáp chuyến bay đi Hà Nội. Đến Sb Nội Bài, xe đưa Quý khách đi ăn tối và ngắm hồ Hoàn Kiếm lung linh trong đêm. Nhận phòng khách sạn nghỉ ngơi.',
    1, 1, 1
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES (' LĂNG BÁC - YÊN TỬ ',
    'Quý khách ăn sáng và trả phòng. Xe đưa Quý khách đi tham quan tham quan Lăng Hồ Chủ Tịch. Tiếp tục hành trình xe khởi hành đưa Quý khách đi Yên Tử dùng cơm trưa và tham quan “vùng đất thiêng”:',
    2, 1, 1
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('HOÀNG HÔN TRÊN VỊNH HẠ LONG',
    'Thư giãn, thả lỏng mình với các bài tập Yoga nhẹ nhàng dưới sự hướng dẫn của các chuyên gia của khách sạn. Xe khởi hành đón Quý khách đi Hạ Long.',
    3, 8, 1
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('HẠ LONG – SB NỘI BÀI',
    ' Xe đón Quý khách đi ăn trưa và mua sắm đặc sản tại Hạ Long. ',
    4, 8, 1
    );

INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('TP.HCM – SB NỘI BÀI – HÀ NỘI',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    1, 1, 2
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('HÀ NỘI – SAPA',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    2, 1, 2
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('SAPA – FANSIPAN LEGEND – ĐÈO Ô QUY HỒ',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    3, 1, 2
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('SAPA – LÀO CAI - NINH BÌNH ',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    4, 1, 2
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('NINH BÌNH - HẠ LONG ',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    5, 1, 2
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('VỊNH HẠ LONG - HANG SỬNG SỐT – ĐẢO TI TỐP',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    6, 1, 2
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('HẠ LONG – YÊN TỬ - SB NỘI BÀI',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    7, 8, 2
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('TP.HCM – SB NỘI BÀI – HÀ NỘI',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    1, 1, 3
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('HÀ NỘI – SAPA',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    2, 1, 3
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('SAPA – FANSIPAN LEGEND – Ô QUY HỒ',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    3, 1, 3
    );
INSERT INTO tbl_destination (name, content, `day`, city_id, tour_info_id)
VALUES ('SAPA – LÀO CAI – SB NỘI BÀI',
    'Quý khách đi Hà Nội nhận phòng khách sạn nghỉ ngơi hoặc tự do đi tham quan Hồ Hoàn Kiếm ngắm bên ngoài Tháp Rùa, Đền Ngọc Sơn, Cầu Thê Húc.',
    4, 1, 3
    );

INSERT INTO tbl_tour(departure, departure_time, tour_info_id, tour_guide_id)
VALUES ('SB. Nội Bài', '2022-08-10 07:00:00', 1, 7);

INSERT INTO tbl_tour(departure, departure_time, tour_info_id, tour_guide_id)
VALUES ('SB. Nội Bài', '2022-08-24 07:00:00', 1, 8);

INSERT INTO tbl_tour(departure, departure_time, tour_info_id, tour_guide_id)
VALUES ('SB. Nội Bài', '2022-08-13 07:00:00', 2, 7);

INSERT INTO tbl_tour(departure, departure_time, tour_info_id, tour_guide_id)
VALUES ('SB. Nội Bài', '2022-08-25 07:00:00', 2, 8);

INSERT INTO tbl_tour(departure, departure_time, tour_info_id, tour_guide_id)
VALUES ('SB. Nội Bài', '2022-08-14 07:00:00', 3, 7);

INSERT INTO tbl_booking(total_price, customer_id, tour_id)
VALUES (100, 5, 1);

INSERT INTO tbl_booking(total_price, customer_id, tour_id)
VALUES (50, 6, 1);

INSERT INTO tbl_visitor(name, booking_id)
VALUES ('Duong Qua', 1);

INSERT INTO tbl_visitor(name, booking_id)
VALUES ('Co Co', 1);

INSERT INTO tbl_visitor(name, booking_id)
VALUES ('Diep Van', 2);
