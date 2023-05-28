// Enums
import { EnvName } from '@enums/environment.enum';

// Packages
import packageInfo from '../../package.json';

const scheme = 'http://';
const host = 'localhost';
const port = ':5000';
const path = '/api/';

const baseUrl = scheme + host + port + path;
const live_baseUrl =
  'https://personalized-travel-recommender-production.up.railway.app';

const endpoints_prefix = '/api/v1/';

export const environment = {
  production: true,
  version: packageInfo.version,
  appName: 'PTR-DASHBOARD',
  envName: EnvName.PROD,
  defaultLanguage: 'en',
  apiBaseUrl: live_baseUrl,
  endpointsPrefix: endpoints_prefix,
};
