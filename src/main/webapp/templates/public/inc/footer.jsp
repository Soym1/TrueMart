<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer class="off-white-bg2 pt-95 bdr-top pt-sm-55">

    <!-- Footer Top Start -->
    <div class="footer-top">
        <div class="container">
            <!-- Signup Newsletter Start -->
            <div class="row mb-60" style="margin-left: 25%;">
                <div class="col-xl-7 col-lg-7 ml-auto mr-auto col-md-8">
                    <div class="news-desc text-center mb-30">
                        <h3>Sign Up For Newsletters</h3>
                        <p>Be the First to Know. Sign up for newsletter today</p>
                    </div>
                    <div class="newsletter-box">
                        <form action="#">
                            <input class="subscribe" placeholder="your email address" name="email" id="subscribe" type="text">
                            <button type="submit" class="submit">subscribe!</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Signup-Newsletter End -->
            <div class="row">
                <!-- Single Footer Start -->
                <div class="col-lg-2 col-md-4 col-sm-4">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title">Information</h3>
                        <div class="footer-content">
                            <ul class="footer-list">
                                <li><a href="about.html">About Us</a></li>
                                <li><a href="#">Delivery Information</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="/view/public/contact.jsp">Terms & Conditions</a></li>
                                <li><a href="/view/public/login.jsp">FAQs</a></li>
                                <li><a href="/view/public/login.jsp">Return Policy</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
                <!-- Single Footer Start -->
                <div class="col-lg-2 col-md-4 col-sm-4">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title">Customer Service</h3>
                        <div class="footer-content">
                            <ul class="footer-list">
                                <li><a href="/view/public/contact.jsp">Contact Us</a></li>
                                <li><a href="#">Returns</a></li>
                                <li><a href="#">Order History</a></li>
                                <li><a href="wishlist.html">Wish List</a></li>
                                <li><a href="#">Site Map</a></li>
                                <li><a href="#">Gift Certificates</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
                <!-- Single Footer Start -->
                <div class="col-lg-2 col-md-4 col-sm-4">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title">Extras</h3>
                        <div class="footer-content">
                            <ul class="footer-list">
                                <li><a href="#">Newsletter</a></li>
                                <li><a href="#">Brands</a></li>
                                <li><a href="#">Gift Certificates</a></li>
                                <li><a href="#">Affiliate</a></li>
                                <li><a href="#">Specials</a></li>
                                <li><a href="#">Site Map</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
                <!-- Single Footer Start -->
                <div class="col-lg-2 col-md-4 col-sm-4">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title">My Account</h3>
                        <div class="footer-content">
                            <ul class="footer-list">
                                <li><a href="/view/public/contact.jsp">Contact Us</a></li>
                                <li><a href="#">Returns</a></li>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Order History</a></li>
                                <li><a href="wishlist.html">Wish List</a></li>
                                <li><a href="#">Newsletter</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
                <!-- Single Footer Start -->
                <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="single-footer mb-sm-40">
                        <h3 class="footer-title">My Account</h3>
                        <div class="footer-content">
                            <ul class="footer-list address-content">
                                <li>Address: 169-C, Technohub, Dubai Silicon Oasis.</li>
                                <li><a href="#"> mail Us: Support@truemart.com </a></li>
                                <li>Phone: (+800) 123 456 789)</li>
                            </ul>
                            <div class="payment mt-25 bdr-top pt-30">
                                <a href="#"><img class="img" src="/templates/public/img/payment/1.png" alt="payment-image"></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Single Footer Start -->
            </div>
            <!-- Row End -->
        </div>
        <!-- Container End -->
    </div>
    <!-- Footer Top End -->
    <!-- Footer Middle Start -->
    <div class="footer-middle text-center">
        <div class="container">
            <div class="footer-middle-content pt-20 pb-30">
                <ul class="social-footer">
                    <li><a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="https://twitter.com/"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="https://plus.google.com/"><i class="fa fa-google-plus"></i></a></li>
                    <li><a href="https://www.linkedin.com/"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><img src="/templates/public/img/icon/social-img1.png" alt="google play"></a></li>
                    <li><a href="#"><img src="/templates/public/img/icon/social-img2.png" alt="app store"></a></li>
                </ul>
            </div>
        </div>
        <!-- Container End -->
    </div>
    <!-- Footer Middle End -->
    <!-- Footer Bottom Start -->
    <div class="footer-bottom pb-30">
        <div class="container">

            <div class="copyright-text text-center">
                <br>Copyright © 2023 <a target="_blank" href="#">Codegym</a></br> All Rights Reserved.</p>
            </div>
        </div>
        <!-- Container End -->
    </div>
    <!-- Footer Bottom End -->
</footer>
<!-- END -->
<script>
        document.getElementById("menu-toggle").onclick = function() {
        document.getElementById("responsive-nav").classList.toggle("active");
    }
</script>
<!-- jQuery Plugins -->
<script src="/templates/public/js/jquery.min.js"></script>
<script src="/templates/public/js/bootstrap.min.js"></script>
<script src="/templates/public/js/slick.min.js"></script>
<script src="/templates/public/js/nouislider.min.js"></script>
<script src="/templates/public/js/jquery.zoom.min.js"></script>
<script src="/templates/public/js/main.js"></script>
<script src="/templates/public/js/mainHandle.js"></script>
<!-- Main Wrapper End Here -->


</body>
</html>
