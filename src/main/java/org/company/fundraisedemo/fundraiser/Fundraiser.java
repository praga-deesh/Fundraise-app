// Profile.js

import React, { useState, useEffect } from 'react';

const Profile = () => {
  const [posts, setPosts] = useState([]);
  const user = JSON.parse(sessionStorage.getItem('user')); // Retrieve user from sessionStorage

  useEffect(() => {
    if (!user) {
      // Redirect to login if user is not logged in
      navigate('/login');
    } else {
      // Fetch posts for the logged-in fundraiser
      fetchPosts(user.id);
    }
  }, [user]);

  const fetchPosts = async (fundraiserId) => {
    try {
      const response = await fetch(`http://localhost:8090/posts/fundraiser/${fundraiserId}`);
      if (!response.ok) {
        throw new Error('Failed to fetch posts');
      }
      const data = await response.json();
      setPosts(data);
    } catch (error) {
      console.error('Error fetching posts:', error);
    }
  };

  return (
    <div>
      <h2>Profile Page</h2>
      <ul>
        {posts.map(post => (
          <li key={post.id}>{post.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default Profile;
