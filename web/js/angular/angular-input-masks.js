'use strict';

module.exports = angular.module('ui.utils.masks', [
	require('./global-masks'),
	require('./br-masks'),
	require('./ch/ch-masks'),
	require('./fr/fr-masks'),
	require('./us/us-masks')
]).name;
