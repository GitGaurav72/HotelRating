var app = angular.module('hotelApp', ['ngRoute']);



app.config(function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'home.html'
    })
    .when('/rooms', {
        templateUrl: './app/hotel/hotel.component.html'
    })
    .when('/about', {
        templateUrl: './app/about/about.component.html'
    })
    .when('/contact', {
        templateUrl: './app/contact-us/contact-us.component.html'
    })
    .when('/login', {
        templateUrl: './app/login/login.component.html',
        controller: 'LoginController'
    })
    .when('/signup', {
        templateUrl: 'signup.html',
        controller: 'SignupController'
    })
    .otherwise({
        redirectTo: '/'
    });
});

app.controller('LoginController', function($scope, $location) {
    $scope.loginData = {};

    $scope.login = function() {
       
        // Perform login logic, redirect to appropriate page
        $location.path('/');
    };
});

app.controller('SignupController', function($scope, $location) {
    $scope.signupData = {};

    $scope.signup = function() {
        // Perform signup logic, redirect to appropriate page
        $location.path('/');
    };
});
