package com.rmaciel.hibernatexml.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/** HibernateUtil - this is helper class to bootstrap hibernate SessionFactory. in most hibernate applications
 * the SessionFactory should be instantiated once during application initialization. The single instance
 * should then be used by all code in a particular process, and any Session should be created using this single
 * SessionFactory. The SessionFactory is trade-safe and be shared, a Session is a single-treaded object.
*/
public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory ==  null) {
			try {
				// Create a registry
				registry = new StandardServiceRegistryBuilder().configure().build();
				
				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);
				
				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();
				
				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
				
			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		
		return sessionFactory;
	}
	
	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
