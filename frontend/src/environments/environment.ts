// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

// Enums
import { EnvName } from '@enums/environment.enum';

// Packages
import packageInfo from '../../package.json';

//https://personalized-travel-recommender-production.up.railway.app/swagger-ui.html
const scheme = 'http://';
const host = 'localhost';
const port = ':5000';
const path = '/api/';

const baseUrl = scheme + host + port + path;
const live_baseUrl =
  'https://personalized-travel-recommender-production.up.railway.app';

const endpoints_prefix = '/api/v1/';

export const environment = {
  production: false,
  version: packageInfo.version,
  appName: 'PTR-DASHBOARD',
  envName: EnvName.LOCAL,
  defaultLanguage: 'en',
  apiBaseUrl: live_baseUrl,
  endpointsPrefix: endpoints_prefix,
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
