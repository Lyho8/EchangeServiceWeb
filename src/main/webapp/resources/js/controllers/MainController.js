angular.module("EchangeServiceWeb")
.controller("MainController", function($scope, $http, $timeout) {
	"use strict";
	
	var mainCtl = this;
	mainCtl.solde = 0;
	
	(function tick() {
		$http.get('/projetf/rest').success(function(data) {
			mainCtl.solde = data.solde;
            $timeout(tick, 10000);
		});
    })();
});