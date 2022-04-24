import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { SafeAreaProvider } from 'react-native-safe-area-context';
import { View,Text } from './components/Themed';

import useCachedResources from './hooks/useCachedResources';
import useColorScheme from './hooks/useColorScheme';
import Navigation from './navigation';
import LoginScreen from './screens/LoginScreen';
export default function App() {
  const isLoadingComplete = useCachedResources();
 
  const colorScheme = useColorScheme();

  if (!isLoadingComplete) {
    return null;
  } else {
    return (
    
<LoginScreen />

     
      // <SafeAreaProvider>
      //   {/* <Navigation colorScheme={colorScheme} />
      //   <StatusBar /> */}
      
      // </SafeAreaProvider>
    );
  }
}
